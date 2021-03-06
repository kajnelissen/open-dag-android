package com.zuyd.fict.opendag.data;

import com.zuyd.fict.opendag.data.repository.IPhotoRepository;
import com.zuyd.fict.opendag.data.repository.IQuestionRepository;
import com.zuyd.fict.opendag.data.repository.IScheduleItemRepository;
import com.zuyd.fict.opendag.data.repository.IStudyRepository;

/**
 * Created by Kaj on 18-9-13.
 */
public interface IEntityManager {

    public IScheduleItemRepository scheduleItems();

    public IQuestionRepository questions();

    public IStudyRepository studies();

    public IPhotoRepository photos();

}
