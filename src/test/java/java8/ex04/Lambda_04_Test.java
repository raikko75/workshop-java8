package java8.ex04;


import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Exercice 04 - FuncCollection
 */
public class Lambda_04_Test {

	// tag::interfaces[]
	interface GenericPredicate<T> {
		boolean test(T t); // 
	}

	interface GenericMapper<T, E> {
		boolean test(T t, E e);
	}

	interface Processor<T> {
		// TODO
	}
	// end::interfaces[]

	// tag::FuncCollection[]
	class FuncCollection<T> {

		private Collection<T> list = new ArrayList<>();

		public void add(T a) {
			list.add(a);
		}

		public void addAll(Collection<T> all) {
			for(T el:all) {
				list.add(el);
			}
		}
		// end::FuncCollection[]

		// tag::methods[]
		private FuncCollection<T> filter(GenericPredicate<T> predicate) {
			FuncCollection<T> result = new FuncCollection<>();
			for (T str : list)
			{
				if (predicate.test(str))
				{
					return result;
				}
			}
			return result;
		}

		private <E> FuncCollection<E> map(GenericMapper<T, E> mapper) {
			FuncCollection<E> result = new FuncCollection<>();
			for (T str : list )
			{
				
			}
			return result;
		}

		private void forEach(Processor<T> processor) {
			// TODO


		}
		// end::methods[]

	}



	// tag::test_filter_map_forEach[]
	@Test
	public void test_filter_map_forEach() throws Exception {

		List<Person> personList = Data.buildPersonList(100);
		FuncCollection<Person> personFuncCollection = new FuncCollection<>();
		personFuncCollection.addAll(personList);

		personFuncCollection
		// TODO filtrer, ne garder uniquement que les personnes ayant un age > 50
		.filter((Person p) -> p.getAge() >50)
		// TODO transformer la liste de personnes en liste de comptes. Un compte a par défaut un solde à 1000.
		.map(null)
		
		/*
		 * 
		ArrayList <T> comptes = new ArrayList<T>();
		ArrayList <Person> prenom = new ArrayList<Person>();
		for (Person p : personList)
		{
			comptes.add( (T) mapper.map(p)); // caster le type de account a t 
		}
		 */
		
		
		
		// TODO vérifier que chaque compte a un solde à 1000.
		// TODO vérifier que chaque titulaire de compte a un age > 50
		.forEach(null);
	}
	// end::test_filter_map_forEach[]

	// tag::test_filter_map_forEach_with_vars[]
	@Test
	public void test_filter_map_forEach_with_vars() throws Exception {

		List<Person> personList = Data.buildPersonList(100);
		FuncCollection<Person> personFuncCollection = new FuncCollection<>();
		personFuncCollection.addAll(personList);

		// TODO créer un variable filterByAge de type GenericPredicate
		// TODO filtrer, ne garder uniquement que les personnes ayant un age > 50
		// ??? filterByAge = ???;

		// TODO créer un variable mapToAccount de type GenericMapper
		// TODO transformer la liste de personnes en liste de comptes. Un compte a par défaut un solde à 1000.
		// ??? mapToAccount = ???;

		// TODO créer un variable verifyAccount de type GenericMapper
		// TODO vérifier que chaque compte a un solde à 1000.
		// TODO vérifier que chaque titulaire de compte a un age > 50
		// ??? verifyAccount = ???;

		/* TODO Décommenter
        personFuncCollection
                .filter(filterByAge)
                .map(mapToAccount)
                .forEach(verifyAccount);
		 */
	}
	// end::test_filter_map_forEach_with_vars[]


}
