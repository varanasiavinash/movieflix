package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.egen.api.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;


	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pemail", email);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		em.remove(user);
	}

}
