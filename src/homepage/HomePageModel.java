package homepage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import department.ContractLecturer;
import department.Department;
import department.FullTimeLecturer;
import department.PartTimeLecturer;

public class HomePageModel {
	static File departmentFileName = new File("Department.dat");
	static File fullTimeLectFileName = new File("Full-TimeLecturer.dat");
	static File partTimeLectFileName = new File("Part-TimeLecturer.dat");
	static File contractLectFileName = new File("ContractLecturer.dat");
	
	//method to add department
	public void addDepartment (int id, String depName, String depType, String depAddress, String depUsername, String depPassword){
		ArrayList<Department> alDep = new ArrayList<Department>();
		alDep = readDepartment();
		alDep.add(new Department(id,depName,depType,depAddress,depUsername,depPassword));
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(departmentFileName));
				oos.writeObject(alDep);
				oos.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

	}
	
	//method to edit department
	public void editDepartment(int id, String depName, String depType, String depAddress, String depUsername, String depPassword) {
		ArrayList<Department> edDep = readDepartment();
		for(int it=0; it<edDep.size(); it++) {
			Department d = new Department(id, depName,depType,depAddress,depUsername,depPassword);
			if(edDep.get(it).id == id) {
				edDep.remove(it);
				edDep.add(d);	 
			}
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(departmentFileName));
				oos.writeObject(edDep);
				d=null;
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
		 }
	}
	
	//method to read department
	public static ArrayList<Department> readDepartment(){
		ArrayList<Department> dp = new ArrayList<> ();
		try {
			FileInputStream fis = new FileInputStream(departmentFileName);
			ObjectInputStream ois = new ObjectInputStream(fis);	
			ArrayList<Department> d = null;
			while(( d = (ArrayList<Department>)ois.readObject()) != null){
				dp=d;
			}
			ois.close();				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("End of file reached.");
        } catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		return dp;	
	}
	
	//method to delete department
	public void deleteDepartment(int id) {
		ArrayList<Department> edDep = readDepartment();
		for(int it=0; it<edDep.size(); it++) {
			if(edDep.get(it).id == id) {
				edDep.remove(edDep.get(it));
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(departmentFileName));
					oos.writeObject(edDep);
					oos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	//Full Time Lecturer
	//method to add full time lecturer
	public void addFullTimeLecturer(int id, String name, String address, String phoneno, String email, String department, String type, String startdate, double salary) {
		ArrayList<FullTimeLecturer> alFTL = new ArrayList<FullTimeLecturer>();
		alFTL = readFullTimeLecturer();
		alFTL.add(new FullTimeLecturer(id,name,address,phoneno,email,department,type,startdate,salary));
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullTimeLectFileName));
			oos.writeObject(alFTL);
			oos.close();
				
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	//method to edit full time lecturer
	public void editFullTimeLecturer(int id, String name, String address, String phoneno, String email, String department, String type, String startdate, double salary) {
		ArrayList<FullTimeLecturer> edFTL = readFullTimeLecturer();
		for(int it=0; it<edFTL.size(); it++) {
			 FullTimeLecturer ft = new FullTimeLecturer(id, name, address, phoneno, email,department, type, startdate, salary);
			 if(edFTL.get(it).id == id) {
				 edFTL.remove(it);
				 edFTL.add(ft);	
			 }
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullTimeLectFileName));
				oos.writeObject(edFTL);
				ft=null;
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
		 }
	}
	
	//method to read full time lecturer
	public static ArrayList<FullTimeLecturer> readFullTimeLecturer(){
		ArrayList<FullTimeLecturer> ftl = new ArrayList<> ();
		try {
			FileInputStream fis = new FileInputStream(fullTimeLectFileName);
			ObjectInputStream ois = new ObjectInputStream(fis);	
			ArrayList<FullTimeLecturer> f = null;
			while(( f = (ArrayList<FullTimeLecturer>)ois.readObject()) != null){
				ftl = f;
			}
			ois.close();	
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("End of file reached.");
        } catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ftl;	
	}
	
	//method to delete full time lecturer
	public void deleteFullTimeLecturer(int id) {
		ArrayList<FullTimeLecturer> edDep = readFullTimeLecturer();
		for(int it=0; it<edDep.size(); it++) {
			if(edDep.get(it).id == id) {
				edDep.remove(edDep.get(it));
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullTimeLectFileName));
					oos.writeObject(edDep);
					oos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
	//Part Time Lecturer
	
	//method to add part time lecturer
		public void addPartTimeLecturer(int id, String name, String address, String phoneno, String email, String department,  String type, String startdate, int hourlyrate) {
			ArrayList<PartTimeLecturer> alPTL = new ArrayList<PartTimeLecturer>();
			alPTL = readPartTimeLecturer();
			alPTL.add(new PartTimeLecturer(id,name,address,phoneno,email,department,type,startdate,hourlyrate));
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(partTimeLectFileName));
					oos.writeObject(alPTL);
					oos.close();
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		//method to read part time lecturer
		public static ArrayList<PartTimeLecturer> readPartTimeLecturer(){
			ArrayList<PartTimeLecturer> ptl = new ArrayList<> ();
			try {
				FileInputStream fis = new FileInputStream(partTimeLectFileName);
				ObjectInputStream ois = new ObjectInputStream(fis);	
				ArrayList<PartTimeLecturer> p = null;
				while(( p = (ArrayList<PartTimeLecturer>)ois.readObject()) != null){
					ptl=p;
				}
				ois.close();	
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {
				System.out.println("End of file reached.");
	        } catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return ptl;	
		}
		
		//method to edit part time lecturer
		public void editPartTimeLecturer(int id, String name, String address, String phoneno, String email, String department, String type, String startdate, int hourlyrate) {
			ArrayList<PartTimeLecturer> edPTL = readPartTimeLecturer();
			for(int it=0; it<edPTL.size(); it++) {
				PartTimeLecturer pt = new PartTimeLecturer(id, name, address, phoneno, email, department, type, startdate, hourlyrate);
				 if(edPTL.get(it).id == id) {
					 edPTL.remove(it);
					 edPTL.add(pt);	
				 }
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(partTimeLectFileName));
					oos.writeObject(edPTL);
					pt=null;
					oos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				 
			 }
		}
		
		//method to delete part time lecturer
		public void deletePartTimeLecturer(int id) {
			ArrayList<PartTimeLecturer> edPTL = readPartTimeLecturer();
			for(int it=0; it<edPTL.size(); it++) {
				if(edPTL.get(it).id == id) {
					edPTL.remove(edPTL.get(it));
					try {
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(partTimeLectFileName));
						oos.writeObject(edPTL);
						oos.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		
		//Contract Lecturer
		
		//method to add contract lecturer
			public void addContractLecturer(int id, String name, String address, String phoneno, String email, String department, String type, String startdate, double salary, String enddate) {
				ArrayList<ContractLecturer> alCL = new ArrayList<ContractLecturer>();
				alCL = readContractLecturer();
				alCL.add(new ContractLecturer(id,name,address,phoneno,email,department,type,startdate,salary,enddate));
					try {
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(contractLectFileName));
						oos.writeObject(alCL);
						oos.close();
						
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				
			//method to read contract lecturer
			public static ArrayList<ContractLecturer> readContractLecturer(){
				ArrayList<ContractLecturer> cl = new ArrayList<> ();
				try {
					FileInputStream fis = new FileInputStream(contractLectFileName);
					ObjectInputStream ois = new ObjectInputStream(fis);	
					ArrayList<ContractLecturer> c = null;
					while(( c = (ArrayList<ContractLecturer>)ois.readObject()) != null){
						cl=c;
					}
					ois.close();	
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (EOFException e) {
					System.out.println("End of file reached.");
		        } catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return cl;	
			}
			
			//method to edit contract lecturer
			public void editContractLecturer(int id, String name, String address, String phoneno, String email, String department, String type, String startdate, double salary, String enddate) {
				ArrayList<ContractLecturer> edPTL = readContractLecturer();
				for(int it=0; it<edPTL.size(); it++) {
					ContractLecturer pt = new ContractLecturer(id, name, address, phoneno, email, department, type, startdate, salary, enddate);
					 if(edPTL.get(it).id == id) {
						 edPTL.remove(it);
						 edPTL.add(pt);	
					 }
					try {
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(contractLectFileName));
						oos.writeObject(edPTL);
						pt=null;
						oos.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					 
				 }
			}
			
			//method to delete contract lecturer
			public void deleteContractLecturer(int id) {
				ArrayList<ContractLecturer> edCL = readContractLecturer();
				for(int it=0; it<edCL.size(); it++) {
					if(edCL.get(it).id == id) {
						edCL.remove(edCL.get(it));
						try {
							ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(contractLectFileName));
							oos.writeObject(edCL);
							oos.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}

			}
}
