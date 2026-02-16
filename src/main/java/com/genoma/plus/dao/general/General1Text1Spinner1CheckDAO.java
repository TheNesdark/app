package com.genoma.plus.dao.general;

import com.genoma.plus.dto.general.General1Text1Spinner1CheckDTO;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/dao/general/General1Text1Spinner1CheckDAO.class */
public interface General1Text1Spinner1CheckDAO {
    List<General1Text1Spinner1CheckDTO> list(String str);

    String create(General1Text1Spinner1CheckDTO general1Text1Spinner1CheckDTO, String str);

    String update(General1Text1Spinner1CheckDTO general1Text1Spinner1CheckDTO, String str);

    String delete(General1Text1Spinner1CheckDTO general1Text1Spinner1CheckDTO, String str);
}
