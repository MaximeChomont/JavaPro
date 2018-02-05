package modele.inter;

public interface ITransaction {
    public void begin();
    public void commit();
    public void rollback();
}
