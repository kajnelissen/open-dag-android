package com.fict.opendag.data;

import com.fict.opendag.data.repository.ArrayQuestionRepository;
import com.fict.opendag.data.repository.ArrayScheduleItemRepository;
import com.fict.opendag.data.repository.ArrayStudyRepository;
import com.fict.opendag.data.repository.IQuestionRepository;
import com.fict.opendag.data.repository.IScheduleItemRepository;
import com.fict.opendag.data.repository.IStudyRepository;
import com.fict.opendag.data.seed.DummyScheduleItemSeeder;
import com.fict.opendag.data.seed.WebScheduleItemSeeder;
import com.fict.opendag.data.seed.IScheduleItemSeeder;
import com.fict.opendag.model.ScheduleItem;

import java.util.List;

/**
 * Created by Kaj on 18-9-13.
 */
public class EntityManager implements IEntityManager {

    private static EntityManager instance = new EntityManager();

    private IScheduleItemRepository _scheduleItems;
    private IQuestionRepository _questions;
    private IStudyRepository _studies;

    public static EntityManager getInstance() {
        return instance;
    }

    private EntityManager() {
        // TODO: DO REFACTOR
        this._scheduleItems = new ArrayScheduleItemRepository();
        this._questions = new ArrayQuestionRepository();
        this._studies = new ArrayStudyRepository();
//        this.seedScheduleItems(new DummyScheduleItemSeeder());
//        this.seedScheduleItems(new WebScheduleItemSeeder());
    }

    public IScheduleItemRepository scheduleItems() {
        return this._scheduleItems;
    }

    public IQuestionRepository questions() {
        return this._questions;
    }

    public IStudyRepository studies() {
        return this._studies;
    }

//    public void seedScheduleItems(IScheduleItemSeeder seeder) {
//        List<ScheduleItem> items = seeder.seed();
//        for ( ScheduleItem item : items ) {
//            this._scheduleItems.add(item);
//        }
//    }
}
