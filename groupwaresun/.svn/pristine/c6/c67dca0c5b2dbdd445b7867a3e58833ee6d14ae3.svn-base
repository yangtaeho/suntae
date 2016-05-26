package com.groupware.sun.team.dto;

public class Team {

	private int team_no;
	private String team_name;

	public Team() {
	}

	public int getTeam_no() {
		return team_no;
	}

	public void setTeam_no(int team_no) {
		this.team_no = team_no;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Team(int team_no, String team_name) {
		super();
		this.team_no = team_no;
		this.team_name = team_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((team_name == null) ? 0 : team_name.hashCode());
		result = prime * result + team_no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (team_name == null) {
			if (other.team_name != null)
				return false;
		} else if (!team_name.equals(other.team_name))
			return false;
		if (team_no != other.team_no)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [team_no=" + team_no + ", team_name=" + team_name + "]";
	}

}
