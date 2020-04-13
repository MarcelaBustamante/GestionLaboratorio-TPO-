import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import com.tpo.model.Paciente;
import com.tpo.model.repos.PacienteRepository;

@DisplayName("PacienteRepositoryTest")
public class PacienteRepositoryTest {

	PacienteRepository p = PacienteRepository.getInstance();
	

	@Test
	@DisplayName("save guardar un elemento en la lista")
	void agregarElemento(){
		Paciente unPaciente = new Paciente();
		unPaciente.setDni(95564);
		unPaciente.setDomicilio("calle falsa 123");
		unPaciente.setEdad(12);
		unPaciente.setNombre("Martha Cebolla");
		unPaciente.setMail("UnaCebolla@totem.com");
		unPaciente.setSexo("trans");
		unPaciente.setIdPaciente(p.seq());
		p.save(unPaciente);
		assertEquals(1,p.findAll().size());
	}
	
	@Test
	@DisplayName("findAll devuelve lista vacia")
	void findAllListaVacia(){
		assertTrue(p.findAll().size() > 0);
	}
	
}
