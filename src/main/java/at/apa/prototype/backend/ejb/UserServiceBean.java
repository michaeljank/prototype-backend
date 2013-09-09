package at.apa.prototype.backend.ejb;


import at.apa.prototype.backend.entity.User;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserServiceBean implements UserServiceLocal, UserServiceRemote {
	@PersistenceContext(unitName = "prototype.backend")
	private javax.persistence.EntityManager em;

	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	public void changeUser(User user) {
		em.merge(user);
	}

	@Override
	public void deleteUser(int id) {
		em.remove(getUser(id));
	}

	@Override
	public User getUser(int id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> getUsers() {
		Query q = em.createQuery("select u from User u");
		return q.getResultList();
	}
}
