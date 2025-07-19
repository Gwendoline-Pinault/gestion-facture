public class AuthService {
    private UserDAO userDAO = new UserDAO();

    public boolean register(String username, String password) throws Exception {
        if (userDAO.findByUsername(username) != null){
            return false;
        };
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(PasswordUtil.hashPassword(password));
        userDAO.save(user);
        return true;
    }

    public User login(String username, String password) throws Exception {
        User user = userDAO.findByUsername(username);
        if (user != null & user.getPassword().equals(PasswordUtil.hashPassword(password))) {
            return user;
        }
        return null;
    }
}