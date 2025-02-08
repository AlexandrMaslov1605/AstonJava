public class User {
    private String name;
    private String password;
    private String mail;

    private User(UserBuilder userBuilder) {
        name = userBuilder.name;
        password = userBuilder.password;
        mail = userBuilder.mail;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public static class UserBuilder {
        private String name;
        private String password;
        private String mail;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
