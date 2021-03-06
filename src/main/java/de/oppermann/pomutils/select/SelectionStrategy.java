package de.oppermann.pomutils.select;

/**
 * Strategy to use to select a version to resolve conflicts.
 */
public enum SelectionStrategy {
	
	/**
	 * Always select 'our' version (the default). 
	 */
	OUR(new OurVersionSelector()),
	
	/**
	 * Always select 'their' version. 
	 */
	THEIR(new TheirVersionSelector()),

	/*
	 *
	 */
	DKV(new DKVVersionSelector()),
	
	/**
	 * Prompt the user via stdout/stdin for them to select the version. 
	 */
	PROMPT(new PersistentVersionSelector(new StreamVersionSelector()));
	
	private final VersionSelector selector;
	
	private SelectionStrategy(VersionSelector selector) {
		this.selector = selector;
	}

	/*
	 * Overridden so that the proper string appears in --help output. 
	 */
	public String toString() {
		return name().toLowerCase();
	}
	
	public VersionSelector getSelector() {
		return selector;
	}
}
