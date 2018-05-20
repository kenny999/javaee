package interceptors;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class LevelBean {
	
	private int level = -1;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
