package java8.ex02;

import java8.data.Account;
import java8.data.Person;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - java.util.function.BiFunction
 */
public class Function_02_Test {

    //  tag::buildAccount[]
    // TODO Compléter la fonction buildAccount
    // TODO la fonction possède 2 paramètres en entrée : une personne et un solde
    BiFunction<Person, Integer, Account> buildAccount = (Person p, Integer solde) ->
    		{
    			Account a = new Account();
    			a.setOwner(p);
    			a.setBalance(solde);
    			return a;
    			
    		};
    //  end::buildAccount[]

    @Test
    public void test_build_account() throws Exception {
    	Person p = new Person("John","France",80, "pass");
    	
        // TODO invoquer la fonction buildAccount pour que le test soit passant
        Account account = buildAccount.apply(p, 500);

        assertThat(account, hasProperty("balance", is(500)));
        assertThat(account.getOwner(), hasProperty("firstname", is("John")));
        assertThat(account.getOwner(), hasProperty("lastname", is("France")));
        assertThat(account.getOwner(), hasProperty("age", is(80)));
        assertThat(account.getOwner(), hasProperty("password", is("pass")));
    }


}
