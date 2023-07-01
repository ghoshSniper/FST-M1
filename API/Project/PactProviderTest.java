package activities;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testng.annotations.Test;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.Response;
import au.com.dius.pact.core.model.annotations.Pact;
import au.com.dius.pact.core.model.annotations.PactFolder;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

@Provider("UserProvider")
@PactFolder("target/pacts")
public class PactProviderTest {
	
	@BeforeEach
	void before(PactVerificationContext context) {
	    // Set target for provider to send request to
	    context.setTarget(new HttpTestTarget("localhost", 8585));
	}
	
	@TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactTestTemplate(PactVerificationContext context) {
  	   // Verify the interaction between Consumer and Provider
  	   // using the contract generated in target/pacts
  	   context.verifyInteraction();
    }

	// State to send the call to consumer
	@State("A request to create a user")
	public void sampleState() {}

}
