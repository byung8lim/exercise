package com.byung8.fitness.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodUnit {
/*
  A.FS_ID as foodUnitId
  , A.FS_VAL as foodValue
  , A.FS_NM_ENG as foodUnitEngName
  , A.FS_NM as foodUnitName
  , A.FS_DTL as descrition
  , A.CD_PRFX_ID as prefixCodedId
  , (SELECT B.CMM_CD_NM FROM TB_CMM_CD B WHERE B.CMM_CD_ID=A.CD_PRFX_ID) as prefixCodeName
  , A.FS_TP_ID as foodTypeId
  , (SELECT B.CMM_CD_NM FROM TB_CMM_CD B WHERE B.CMM_CD_ID=A.FS_TP_ID) as foodTypeName
  , A.BS_UNT_VAL as baseUnitValue
  , A.FS_UNT_VAL as UnitQuantity
  , A.USE_YN as useYn
  , A.REG_DT as regDate
  , A.UDP_DT as udpDate
 */
	private String foodUnitId;
	private int foodValue;
	private String foodUnitEngName;
	private String foodUnitName;
	private String descrition;
	private String prefixCodedId;
	private String prefixCodeName;
	private String foodTypeId;
	private String foodTypeName;
	private float baseUnitValue;
	private float UnitQuantity;
	private String useYn;
	private Date regDate;
	private Date udpDate;
}
