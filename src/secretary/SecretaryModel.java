package secretary;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import department.ContractLecturer;
import department.FullTimeLecturer;
import department.PartTimeLecturer;
import homepage.HomePageModel;

public class SecretaryModel {
	//method to read Lecturers
	public ArrayList<FullTimeLecturer> readFullTimeLecturer(){
		ArrayList<FullTimeLecturer> rftl = HomePageModel.readFullTimeLecturer();
		return rftl;
	}
	public ArrayList<PartTimeLecturer> readPartTimeLecturer(){
		ArrayList<PartTimeLecturer> rptl = HomePageModel.readPartTimeLecturer();
		return rptl;
	}
	public ArrayList<ContractLecturer> readContractLecturer(){
		ArrayList<ContractLecturer> rcl = HomePageModel.readContractLecturer();
		return rcl;
	}
	
}
