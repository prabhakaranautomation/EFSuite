//package zFeature;
//
//import java.lang.reflect.Method;
//
//import org.testng.ITestNGMethod;
//import org.testng.ITestResult;
//
//public class TestNGcounterofDataProviderrows 
//{
//	/**
//	@Override
//    public void onTestStart(ITestResult iTestResult) {
//        // Attempt to count invocations of a DataProvider-instrumented test
//        Object instance = iTestResult.getInstance();
//        ITestNGMethod testNGMethod = iTestResult.getMethod();
//        
//        Method testMethod = testNGMethod.getMethod();
//        if (testMethod.isAnnotationPresent(Test.class) && testMethod.isAnnotationPresent(Count.class)) {
//            Test testMethodTestAnnotation = testMethod.getAnnotation(Test.class);
//            String dataProviderName = testMethodTestAnnotation.dataProvider();
//            if (dataProviderName != null && !dataProviderName.isEmpty()) {
//                Class<?> aClass = instance.getClass();
//                Method[] allTestClassMethods = aClass.getMethods();
//                for (Method m : allTestClassMethods) {
//                    
//                    -----
//                    Counting will silently fail for Test classes using a DataProvider defined outside the test class instance itself.
//                    The reason is that the following code does not look outside the test class instance for the DataProvider method.
//                     -----------
//                    
//					if (m.isAnnotationPresent(DataProvider.class)) {
//                        DataProvider dataProviderAnnotation = m.getAnnotation(DataProvider.class);
//                        String thisDataProviderName = dataProviderAnnotation.name();
//                        if (dataProviderName.equals(thisDataProviderName)) {
//                            try {
//                                Object[][] theData = (Object[][]) m.invoke(instance);
//                                Integer numberOfDataProviderRows = theData.length;
//                                System.out.printf("Executing %s %d / %d\n", iTestResult.getName(), testNGMethod.getCurrentInvocationCount() + 1, numberOfDataProviderRows);
//                            } catch (IllegalAccessException e) {
//                                e.printStackTrace();
//                            } catch (InvocationTargetException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                    
//                }
//            }
//        }
//        
//    }
//    **/
//}
