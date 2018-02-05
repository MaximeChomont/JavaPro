package modele.inter;

import annotations.Transactionnal;

@Transactionnal
public interface ITransactionnalObject {
    public void businessLogic();
    public void businessLogicWithErrors() throws Exception;
}
