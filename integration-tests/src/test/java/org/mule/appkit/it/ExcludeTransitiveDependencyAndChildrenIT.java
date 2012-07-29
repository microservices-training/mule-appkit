package org.mule.appkit.it;

import java.io.File;

import static junit.framework.Assert.assertTrue;

public class ExcludeTransitiveDependencyAndChildrenIT extends AbstractMavenIT {

    @Override
    protected String getArtifactVersion() {
        return "1.0";
    }

    @Override
    protected String getArtifactId() {
        return "exclude-transitive-with-child";
    }

    @Override
    protected String getGroupId() {
        return "org.mule.appkit.it";
    }

    @Override
    protected File getRoot() {
        return new File("target/integration-tests/" + getArtifactId());
    }

    @Override
    protected void verify() throws Exception {
        File zipFile = zipFileFromBuildingProject();

        assertZipDoesNotContain(zipFile, "lib/mule-core-3.3.0.jar", "lib/log4j-1.2.14.jar");
    }
}
