package dmit2015.model;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("JUnit 5 Platform Suite")
@SelectPackages("dmit2015.model")
@IncludeClassNamePatterns(".*Test")
//@SelectClasses({PersonTest.class})
public class AllUnitTests
{
// the class remains completely empty,
// being used only as a holder for the above annotations
}