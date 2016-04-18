package edu.usm.cos420.health.consultingregister.domain;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.TreeMap;

import edu.usm.cos420.health.domain.Person;
import edu.usm.cos420.health.domain.Person.Info;

public class RegisterItem implements Serializable{
	private static final long serialVersionUID = 1L;
	private Person patient;
	private Info info;
	private Vitals vitals;

	public static class Info implements Serializable{
		private static final long serialVersionUID = 1L;
		private static final int DATE = 0;
		private static final int YEAR = 1;
		private static final int FACILITY = 2;
		private static final int SUB_DIST = 3;
		private static final int DIST = 4;
		private static final int NEW_CASE = 5;
		private static final int PRINC_DIAG = 6;
		private static final int ADD_DIAG = 7;
		private static final int TREATMENT = 8;
		private static final int REFERRED = 9;
		private static final int REFER_OUTCOME = 10;
		private static final int REMARKS = 11;

		private TreeMap<Integer, String> keyed_info;

		public Info() {
			keyed_info = new TreeMap<Integer, String>();
		}

		public Info(String d, String y, String f, String sd, String dst, String nc, String pd, String ad, String t,
				String r, String ro, String rmks) {
			keyed_info = new TreeMap<Integer, String>();
			keyed_info.put(DATE, d);
			keyed_info.put(YEAR, y);
			keyed_info.put(FACILITY, f);
			keyed_info.put(SUB_DIST, sd);
			keyed_info.put(DIST, dst);
			keyed_info.put(NEW_CASE, nc);
			keyed_info.put(PRINC_DIAG, pd);
			keyed_info.put(ADD_DIAG, ad);
			keyed_info.put(TREATMENT, t);
			keyed_info.put(REFERRED, r);
			keyed_info.put(REFER_OUTCOME, ro);
			keyed_info.put(REMARKS, rmks);
		}

		public Info(Map<Integer, String> info) throws InputMismatchException {
			keyed_info = new TreeMap<Integer, String>();

			for (Integer key : info.keySet()) {
				switch (key.intValue()) {
				case DATE:
					keyed_info.put(key, info.get(key));
					break;
				case YEAR:
					keyed_info.put(key, info.get(key));
					break;
				case FACILITY:
					keyed_info.put(key, info.get(key));
					break;
				case SUB_DIST:
					keyed_info.put(key, info.get(key));
					break;
				case DIST:
					keyed_info.put(key, info.get(key));
					break;
				case NEW_CASE:
					keyed_info.put(key, info.get(key));
					break;
				case PRINC_DIAG:
					keyed_info.put(key, info.get(key));
					break;
				case ADD_DIAG:
					keyed_info.put(key, info.get(key));
					break;
				case TREATMENT:
					keyed_info.put(key, info.get(key));
					break;
				case REFERRED:
					keyed_info.put(key, info.get(key));
					break;
				case REFER_OUTCOME:
					keyed_info.put(key, info.get(key));
					break;
				case REMARKS:
					keyed_info.put(key, info.get(key));
					break;
				default:
					throw new InputMismatchException();
				}
			}
		}

		public boolean contains(RegisterItem.Info other) {
			for (Integer key : other.keyed_info.keySet()) {
				String other_value = other.keyed_info.get(key);
				if (!other_value.equals("") && !this.keyed_info.get(key).equals(other_value))
					return false;
			}
			return true;
		}

		public String getDate() {
			return keyed_info.get(DATE);
		}

		public void setDate(String d) {
			keyed_info.put(DATE, d);
		}

		public String getYear() {
			return keyed_info.get(YEAR);
		}

		public void setYear(String y) {
			keyed_info.put(YEAR, y);
		}

		public String getFacility() {
			return keyed_info.get(FACILITY);
		}

		public void setFacility(String f) {
			keyed_info.put(FACILITY, f);
		}

		public String getSubDist() {
			return keyed_info.get(SUB_DIST);
		}

		public void setSubDist(String sd) {
			keyed_info.put(SUB_DIST, sd);
		}

		public String getDist() {
			return keyed_info.get(DIST);
		}

		public void setDist(String d) {
			keyed_info.put(DIST, d);
		}

		public String getNewCase() {
			return keyed_info.get(NEW_CASE);
		}

		public void setNewCase(String nc) {
			keyed_info.put(NEW_CASE, nc);
		}

		public String getPrincDiag() {
			return keyed_info.get(PRINC_DIAG);
		}

		public void setPrincDiag(String pd) {
			keyed_info.put(PRINC_DIAG, pd);
		}

		public String getAddDiag() {
			return keyed_info.get(ADD_DIAG);
		}

		public void setAddDiag(String ad) {
			keyed_info.put(ADD_DIAG, ad);
		}

		public String getTreatment() {
			return keyed_info.get(TREATMENT);
		}

		public void setTreatment(String t) {
			keyed_info.put(TREATMENT, t);
		}

		public String getReferred() {
			return keyed_info.get(REFERRED);
		}

		public void setReferred(String r) {
			keyed_info.put(REFERRED, r);
		}

		public String getReferOutcome() {
			return keyed_info.get(REFER_OUTCOME);
		}

		public void setReferOutcome(String ro) {
			keyed_info.put(REFER_OUTCOME, ro);
		}

		public String getRemarks() {
			return keyed_info.get(REMARKS);
		}

		public void setRemarks(String r) {
			keyed_info.put(REMARKS, r);
		}
	}

	public static class Vitals implements Serializable{
		private static final long serialVersionUID = 1L;
		private static final int BLOOD_PRESS = 0;
		private static final int PULSE = 1;
		private static final int TEMP = 2;
		private static final int WEIGHT = 3;
		private static final int RESP = 4;

		private TreeMap<Integer, String> keyed_vitals;

		public Vitals() {
			keyed_vitals = new TreeMap<Integer, String>();
		}

		public Vitals(String bp, String p, String t, String w, String r) {
			keyed_vitals = new TreeMap<Integer, String>();
			keyed_vitals.put(BLOOD_PRESS, bp);
			keyed_vitals.put(PULSE, p);
			keyed_vitals.put(TEMP, t);
			keyed_vitals.put(WEIGHT, w);
			keyed_vitals.put(RESP, r);
		}

		public Vitals(Map<Integer, String> vitals) throws InputMismatchException {
			keyed_vitals = new TreeMap<Integer, String>();

			for (Integer key : vitals.keySet()) {
				switch (key.intValue()) {
				case BLOOD_PRESS:
					keyed_vitals.put(key, vitals.get(key));
					break;
				case PULSE:
					keyed_vitals.put(key, vitals.get(key));
					break;
				case TEMP:
					keyed_vitals.put(key, vitals.get(key));
					break;
				case WEIGHT:
					keyed_vitals.put(key, vitals.get(key));
					break;
				case RESP:
					keyed_vitals.put(key, vitals.get(key));
					break;
				default:
					throw new InputMismatchException();
				}
			}
		}

		public boolean contains(RegisterItem.Vitals other) {
			for (Integer key : other.keyed_vitals.keySet()) {
				String other_value = other.keyed_vitals.get(key);
				if (!other_value.equals("") && !this.keyed_vitals.get(key).equals(other_value))
					return false;
			}
			return true;
		}

		public String getBloodPress() {
			return keyed_vitals.get(BLOOD_PRESS);
		}

		public void setBloodPress(String bp) {
			keyed_vitals.put(BLOOD_PRESS, bp);
		}

		public String getPulse() {
			return keyed_vitals.get(PULSE);
		}

		public void setPulse(String p) {
			keyed_vitals.put(PULSE, p);
		}

		public String getTemp() {
			return keyed_vitals.get(TEMP);
		}

		public void setTemp(String t) {
			keyed_vitals.put(TEMP, t);
		}

		public String getWeight() {
			return keyed_vitals.get(WEIGHT);
		}

		public void setWeight(String w) {
			keyed_vitals.put(WEIGHT, w);
		}

		public String getResp() {
			return keyed_vitals.get(RESP);
		}

		public void setResp(String r) {
			keyed_vitals.put(RESP, r);
		}
	}

	public RegisterItem() {
		patient = new Person();
		info = new Info();
		vitals = new Vitals();
	}

	public RegisterItem(Person.Info p, Info i, Vitals v) {
		patient = new Person(p);
		info = i;
		vitals = v;
	}

	// parameterized constructor
	public RegisterItem(Person pt, String d, String y, String f, String sd, String dst, String nc, String pd, String ad,
			String t, String r, String ro, String rk, String bp, String p, String tmp, String w, String rsp) {
		patient = pt;
		info = new Info();
		info.setDate(d);
		info.setYear(y);
		info.setSubDist(sd);
		info.setDist(dst);
		info.setNewCase(nc);
		info.setPrincDiag(pd);
		info.setAddDiag(ad);
		info.setTreatment(t);
		info.setReferred(r);
		info.setReferOutcome(ro);
		info.setRemarks(rk);
		vitals = new Vitals();
		vitals.setBloodPress(bp);
		vitals.setPulse(p);
		vitals.setTemp(tmp);
		vitals.setWeight(w);
		vitals.setResp(rsp);
	}

	public Person getPatient() {
		return patient;
	}

	public void setPatient(Person p) {
		patient = p;
	}

	public RegisterItem.Info getInfo() {
		return info;
	}

	public RegisterItem.Vitals getVitals() {
		return vitals;
	}

	public String getDate() {
		return info.getDate();
	}

	public void setDate(String d) {
		info.setDate(d);
	}

	public String getYear() {
		return info.getYear();
	}

	public void setYear(String y) {
		info.setYear(y);
	}

	public String getFacility() {
		return info.getFacility();
	}

	public void setFacility(String f) {
		info.setFacility(f);
	}

	public String getSubDist() {
		return info.getSubDist();
	}

	public void setSubDist(String sd) {
		info.setSubDist(sd);
	}

	public String getDist() {
		return info.getDist();
	}

	public void setDist(String d) {
		info.setDist(d);
	}

	public String getNewCase() {
		return info.getNewCase();
	}

	public void setNewCase(String nc) {
		info.setNewCase(nc);
	}

	public String getPrincDiag() {
		return info.getPrincDiag();
	}

	public void setPrincDiag(String pd) {
		info.setPrincDiag(pd);
	}

	public String getAddDiag() {
		return info.getAddDiag();
	}

	public void setAddDiag(String ad) {
		info.setAddDiag(ad);
	}

	public String getTreatment() {
		return info.getTreatment();
	}

	public void setTreatment(String t) {
		info.setTreatment(t);
	}

	public String getReferred() {
		return info.getReferred();
	}

	public void setReferred(String r) {
		info.setReferred(r);
	}

	public String getReferOutcome() {
		return info.getReferOutcome();
	}

	public void setReferOutcome(String ro) {
		info.setReferOutcome(ro);
	}

	public String getRemarks() {
		return info.getRemarks();
	}

	public void setRemarks(String r) {
		info.setRemarks(r);
	}

	public String getBloodPress() {
		return vitals.getBloodPress();
	}

	public void setBloodPress(String bp) {
		vitals.setBloodPress(bp);
	}

	public String getPulse() {
		return vitals.getPulse();
	}

	public void setPulse(String p) {
		vitals.setPulse(p);
	}

	public String getTemp() {
		return vitals.getTemp();
	}

	public void setTemp(String t) {
		vitals.setTemp(t);
	}

	public String getWeight() {
		return vitals.getWeight();
	}

	public void setWeight(String w) {
		vitals.setWeight(w);
	}

	public String getResp() {
		return vitals.getResp();
	}

	public void setResp(String r) {
		vitals.setResp(r);
	}

	public String toString() {
		return "Date: " + getDate() + " Year: " + getYear() + " Facility: " + getFacility() + " Sub-District: "
				+ getSubDist() + " District: " + getDist() + " New Case: " + getNewCase() + " Principal Diagnosis: "
				+ getPrincDiag() + " Additional Diagnoses: " + getAddDiag() + " Treatment: " + getTreatment()
				+ " Referred: " + getReferred() + " Referral Outcome: " + getReferOutcome() + " Remarks: " + getRemarks()
				+ " Blood Pressure: " + getBloodPress() + " Pulse: " + getPulse() + " Temperature: " + getTemp()
				+ " Weight: " + getWeight() + " Resp: " + getResp() + "\n Patient: "+getPatient();
	}
}
