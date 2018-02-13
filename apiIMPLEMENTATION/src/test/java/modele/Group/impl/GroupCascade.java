package modele.Group.impl;

import inject.annotations.Inject;
import modele.Group.inter.IGroup;

public class GroupCascade implements IGroup {
    @Inject
    IGroup group;

    public GroupCascade() {
    }

    public IGroup getGroup() {
        return group;
    }

    public void setGroup(IGroup group) {
        this.group = group;
    }
}
