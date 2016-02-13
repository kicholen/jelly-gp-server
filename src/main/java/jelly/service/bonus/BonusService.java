package jelly.service.bonus;

import jelly.entity.bonus.Bonus;
import jelly.exception.bonus.BonusNotFound;

import java.util.List;

public interface BonusService {
    void create(Bonus bonus);

    Bonus delete(long id) throws BonusNotFound;

    List<Bonus> getAll();

    Bonus update(Bonus bonus) throws BonusNotFound;

    Bonus findById(long id) throws BonusNotFound;
}
