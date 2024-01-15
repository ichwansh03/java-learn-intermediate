public record Customer(Long id, String name, String email, String phone) {

    public Customer(Long id, String name, String email) {
        this(id, name, email, null);
    }

    public Customer(Long id, String name) {
        this(id, name, null);
    }
}
