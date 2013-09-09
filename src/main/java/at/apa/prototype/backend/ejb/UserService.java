package at.apa.prototype.backend.ejb;

import at.apa.prototype.backend.entity.User;

import java.util.List;

public interface UserService {
	public void addUser(User user);
	public void changeUser(User user);
	public void deleteUser(int id);
	public User getUser(int id);
	public List<User> getUsers();
}
