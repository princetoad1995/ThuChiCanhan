package com.princetoad.costmanagement.View;

import com.princetoad.costmanagement.Common.Domain.ManageDTO;
import com.princetoad.costmanagement.Common.Domain.NotedDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 5/12/2017.
 */

public interface ListNoteView extends ViewBase{
    public void setList(NotedDTO noted, List<ManageDTO> listManage);
}
