package silentwing算法冲刺.session03_graph;

//Project: techbow
//Package: silentwing算法冲刺
//ClassName: JobScheduler
//Author: Zeshi(Jesse) Yang
//Date: 2020-12-09 星期三 19:55

/**
 * There are n projects labeled from 0 to n - 1. Some projects are dependent on other projects. For
 * example, to complete project 0 you have to first finish project 1, which is expressed as a pair:
 * [0, 1]. Also, the project x requires y days to finish, which will present as timeline <x, y>, the
 * projects can be processed in parallel. Now if one plans to use the shortest time to finish all
 * the projects, what is the timeline of all the projects by starting date?
 * <p>
 * input: n = 3, prerequisites = [[1, 0]] timeline[0] = 1 timeline[1] = 2 timeline[2] = 3 output:
 * [2, 0, 1]
 * <p>
 * input: n = 2, prerequisites = [[1, 0], [0, 1]] timeline[0] = 1 timeline[1] = 2 output: []
 */
public class JobScheduler { // TODO
	
	private class Project {
		
		private int id; // 0.. n-1
		private int duration;
		
		public Project(int id, int duration) {
			this.id = id;
			this.duration = duration;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (!(o instanceof Project)) {
				return false;
			}
			
			Project project = (Project) o;
			
			if (id != project.id) {
				return false;
			}
			return duration == project.duration;
		}
		
		@Override
		public int hashCode() {
			int result = id;
			result = 31 * result + duration;
			return result;
		}
	}
	
	
	
}
