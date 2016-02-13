package jelly.repository.bonus;

import jelly.entity.bonus.Bonus;

import java.util.List;

public interface BonusRepository {
    Bonus findOne(long id);

    List<Bonus> findAll();

    void create(Bonus entity);

    Bonus update(Bonus entity);

    void delete(long entityId);
}
