package com.locadora.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class GenericDAO <T> {

	static EntityManagerFactory factory = null;
	private Class<T> classe;

	static {

		factory = Persistence.createEntityManagerFactory("Locadora_PU");

	}

	@SuppressWarnings("unchecked")
	public GenericDAO(){

		Class<?> thisClass = getClass();
		System.out.println(thisClass);
		ParameterizedType t = (ParameterizedType) thisClass.getGenericSuperclass();
		Type t2 = t.getActualTypeArguments()[0];
		System.out.println(t2);
		this.classe = (Class<T>) t2;

	}

	public T localizar(int id) {

		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		T obj = null;

		try {

			t.begin();
			obj = em.find(classe, id);
			t.commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (t.isActive()) t.rollback();

		} finally {

			em.close();
		}

		return obj;

	}

	@SuppressWarnings("unchecked")
	public List<T> localizarAll() {

		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		List<T> list = null;

		try {

			t.begin();
			list = (List<T>) em.createQuery("from " + classe.getSimpleName()).getResultList();
			t.commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (t.isActive()) t.rollback();

		} finally {

			em.close();
		}

		return list;

	}

	public T inserir(T obj) {

		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {

			t.begin();
			obj = em.merge(obj);
			t.commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (t.isActive()) t.rollback();

		} finally {

			em.close();

		}

		return obj;

	}

	public void excluir(int id) {

		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		T obj = null;

		try {

			t.begin();
			obj = em.find(classe, id);
			em.remove(obj);
			t.commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (t.isActive()) t.rollback();

		} finally {

			em.close();
		}

	}
	
	public void atualizar(T obj) {

		EntityManager em = factory.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {

			t.begin();
			em.merge(obj);
			t.commit();

		} catch (Exception e) {

			e.printStackTrace();
			if (t.isActive()) t.rollback();

		} finally {

			em.close();

		}

	}
}