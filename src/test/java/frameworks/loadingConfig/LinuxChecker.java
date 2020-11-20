package frameworks.loadingConfig;

public interface LinuxChecker {

	default boolean isLinux() {
		String os = System.getProperty("os.name");
		return os.startsWith("Linux");
	}
}
