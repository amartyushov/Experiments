package io.mart;

import java.util.ArrayList;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoUsageExamples {
	
	@Test
	public void recommended_way_of_behaviour_definition() {
		
		DataService service = mock(DataService.class);
		
		when(service.getData()).thenReturn(new ArrayList<>());
	}
	
	
	@Test
	public void alternative_way_of_behaviour_definition() {
		
		DataService service = mock(DataService.class);
		
		doReturn(new ArrayList<>()).when(service).getData();
		// there is no check here at compiletime that type of doReturn(..) and following used method getData() are same
		doReturn(new ArrayList<>()).when(service).getDataById(""); // here datatypes are different
	}
	
	
	@Test
	public void how_to_override_void_return_type() {
	
	
	}
	
	
	@Test
	public void how_to_define_condition_of_invocation() {
		
		DataService service = mock(DataService.class);
		
		// Any
		when(service.getDataById(any())).thenReturn("data");
		
		// Equivalence or same (comparison of object references)
		when(service.getDataById(Mockito.eq("equivalent_parameter"))).thenReturn("data");
		when(service.getDataById(Mockito.same("same_parameter"))).thenReturn("data");
		
		// More complex condition
		when(service.getDataById(Mockito.argThat(
				arg -> arg == null || arg.length() > 5
		))).thenReturn("data");
		
		// It is possible to specify behaviour of the method several times using different conditions
		// If a value in runtime satisfies two conditions => one which declared later wins
		// => make sense to start specifying conditions for same method from most general (e.g. any()) to more specific
		
		// If method accepts several parameters => condition for all parameters have to be satisfied in order to use overridden behaviour
	}
	
	
	@Test
	public void how_to_define_result_of_invocation() {
		
		DataService service = mock(DataService.class);
		
		// You can return only objects, not primitives
		
		// throw an exception
		when(service.getData()).thenThrow(new IllegalStateException());
		when(service.getData()).thenThrow(IllegalStateException.class);
		// you can throw checked exceptions as well, but than method should be declared to throw such exception
		
		// if you want to return smth which is based on the value
	}
}
