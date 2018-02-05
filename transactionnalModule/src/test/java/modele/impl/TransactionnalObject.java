package modele.impl;

import modele.inter.ITransactionnalObject;

public class TransactionnalObject implements ITransactionnalObject {
    @Override
    public void businessLogic() {

    }

    @Override
    public void businessLogicWithErrors() throws Exception {
        throw new Exception();
    }
}
