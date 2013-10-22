package com.zuyd.fict.opendag.data;

import com.zuyd.fict.opendag.data.repository.ArrayPhotoRepository;
import com.zuyd.fict.opendag.data.repository.ArrayQuestionRepository;
import com.zuyd.fict.opendag.data.repository.ArrayScheduleItemRepository;
import com.zuyd.fict.opendag.data.repository.ArrayStudyRepository;
import com.zuyd.fict.opendag.data.repository.IPhotoRepository;
import com.zuyd.fict.opendag.data.repository.IQuestionRepository;
import com.zuyd.fict.opendag.data.repository.IScheduleItemRepository;
import com.zuyd.fict.opendag.data.repository.IStudyRepository;
import com.zuyd.fict.opendag.data.seed.DummyScheduleItemSeeder;
import com.zuyd.fict.opendag.data.seed.WebScheduleItemSeeder;
import com.zuyd.fict.opendag.data.seed.IScheduleItemSeeder;
import com.zuyd.fict.opendag.model.ScheduleItem;

import java.util.List;

/**
 * Created by Kaj on 18-9-13.
 */
public class EntityManager implements IEntityManager {

    private static EntityManager instance = new EntityManager();

    private IScheduleItemRepository _scheduleItems;
    private IQuestionRepository _questions;
    private IStudyRepository _studies;
    private IPhotoRepository _photos;

    public static EntityManager getInstance() {
        return instance;
    }

    private EntityManager() {
        // TODO: DO REFACTOR
        this._scheduleItems = new ArrayScheduleItemRepository();
        this._questions = new ArrayQuestionRepository();
        this._studies = new ArrayStudyRepository();
        this._photos = new ArrayPhotoRepository();
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

    public IPhotoRepository photos() {
        return this._photos;
    }

//    public void seedScheduleItems(IScheduleItemSeeder seeder) {
//        List<ScheduleItem> items = seeder.seed();
//        for ( ScheduleItem item : items ) {
//            this._scheduleItems.add(item);
//        }
//    }
}
