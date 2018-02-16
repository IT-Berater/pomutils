package de.oppermann.pomutils.select;

import de.oppermann.pomutils.util.VersionFieldType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * If the version of the branch we pull from ends with 0-SNAPSHOT, we keep that version, else overwrite it.
 */
public class DKVVersionSelector implements VersionSelector {

	private final Logger logger = LoggerFactory.getLogger(DKVVersionSelector.class);

	@Override
	public String selectVersion(String projectIdentifier, VersionFieldType versionFieldType, String ourVersion, String theirVersion) {
		logger.info("DKVVersionSelector: projectIdentifier: {}", projectIdentifier);
		logger.info("DKVVersionSelector: ourVersion: {}", ourVersion);
		logger.info("DKVVersionSelector: theirVersion: {}", theirVersion);
		if (ourVersion.endsWith("0-SNAPSHOT")) {
			logger.info("Version ends with 0-SNAPSHOT, so select ourVersion");
			return ourVersion;
		} else {
			logger.info("Version does not end with 0-SNAPSHOT, so select theirVersion");
			return theirVersion;
		}
	}

}
