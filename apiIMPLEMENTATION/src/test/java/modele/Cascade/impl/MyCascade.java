package modele.Cascade.impl;

import inject.annotations.Inject;
import modele.Personne.inter.IPersonne;

public class MyCascade {
    @Inject
    IPersonne personne;

    public MyCascade() {
    }

    public IPersonne getPersonne() {
        return personne;
    }

    public void setPersonne(IPersonne personne) {
        this.personne = personne;
    }
}
