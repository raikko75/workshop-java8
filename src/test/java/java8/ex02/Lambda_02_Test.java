package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

	// tag::PersonToAccountMapper[]
	interface PersonToAccountMapper <T> {
		T map(Person p);
	}
	// end::PersonToAccountMapper[]

	// tag::map[]
	private<T> List<T> map(List<Person> personList, PersonToAccountMapper mapper) {
		// TODO implémenter la méthode

		ArrayList <T> comptes = new ArrayList<T>();
		ArrayList <Person> prenom = new ArrayList<Person>();
		for (Person p : personList)
		{
			comptes.add( (T) mapper.map(p)); // caster le type de account a t 
		}
			
		return comptes;
	}
	// end::map[]


	// tag::test_map_person_to_account[]
	@Test
	public void test_map_person_to_account() throws Exception {

		List<Person> personList = Data.buildPersonList(100);
		Account a = new Account();
		// TODO transformer la liste de personnes en liste de comptes
		// TODO tous les objets comptes ont un solde à 100 par défaut
		List<Account> result = map(personList, (p) ->
		{
			a.setOwner(p);
			a.setBalance(100);
			return a;
		});

		assertThat(result, hasSize(personList.size()));
		assertThat(result, everyItem(hasProperty("balance", is(100))));
		assertThat(result, everyItem(hasProperty("owner", notNullValue())));
	}
	// end::test_map_person_to_account[]

	// tag::test_map_person_to_firstname[]
	@Test
	public <T> void test_map_person_to_firstname() throws Exception {

		List<Person> personList = Data.buildPersonList(100);
		
		
		List<String> result = map(personList, (p) ->
		{
			return p.getFirstname();
		});
				
				

		assertThat(result, hasSize(personList.size()));
		assertThat(result, everyItem(instanceOf(String.class)));
		assertThat(result, everyItem(startsWith("first")));
	}
	// end::test_map_person_to_firstname[]
}
