package jelly.service.bonus;

import jelly.entity.bonus.Bonus;
import jelly.exception.bonus.BonusNotFound;
import jelly.repository.bonus.BonusRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BonusServiceImpl implements BonusService {

    @Resource
    BonusRepository entity;

    @Override
    public void create(Bonus bonus) {
        entity.create(bonus);
    }

    @Override
    public Bonus delete(long id) throws BonusNotFound {
        Bonus bonus = findById(id);
        entity.delete(id);
        return bonus;
    }

    @Override
    public List<Bonus> getAll() {
        return entity.findAll();
    }

    @Override
    public Bonus update(Bonus bonus) throws BonusNotFound {
        Bonus savedBonus = findById(bonus.getId());
        entity.update(bonus);
        return savedBonus;
    }

    @Override
    public Bonus findById(long id) throws BonusNotFound {
        Bonus bonus = entity.findOne(id);
        if (bonus == null)
            throw new BonusNotFound();
        return bonus;
    }
}