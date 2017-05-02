package com.princetoad.costmanagement.DAO;

import com.princetoad.costmanagement.Common.Domain.ManageDTO;

import java.util.List;

/**
 * Created by PRINCE D. TOAD on 5/2/2017.
 */

public interface ManageDAO {
    public void addManage(ManageDTO manageDTO);

    public List<ManageDTO> getAllList();
}
