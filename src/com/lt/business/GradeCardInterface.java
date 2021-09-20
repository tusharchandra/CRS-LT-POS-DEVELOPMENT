package com.lt.business;

import java.sql.SQLException;
import java.util.List;

import com.lt.bean.GradeCard;

public interface GradeCardInterface {


	public List<GradeCard> viewGradeCard(int StudentId) throws SQLException;


}
