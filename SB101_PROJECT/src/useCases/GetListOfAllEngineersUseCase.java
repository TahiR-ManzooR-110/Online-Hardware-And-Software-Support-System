package useCases;

import java.util.List;

import custom.ConsoleColors;
import dao.HodDao;
import dao.HodDaoImpl;
import exception.EngineerException;
import model.Engineer;

public class GetListOfAllEngineersUseCase {
	
	public void listOfEngineers() {
		try {
			HodDao dao = new HodDaoImpl();
			List<Engineer> engineers = dao.getListOfAllEngineers();
			engineers.forEach(e -> {
				System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT+"========================================="+ConsoleColors.RESET);
				System.out.println(ConsoleColors.ORANGE+"Engineer's ID: "+ConsoleColors.RESET+e.getEngId());
				System.out.println(ConsoleColors.ORANGE+"Engineer's Name: "+ConsoleColors.RESET+e.getEngName());
				System.out.println(ConsoleColors.ORANGE+"Engineer's Username: "+ConsoleColors.RESET+e.getEngUsername());
				System.out.println(ConsoleColors.ORANGE+"Engineer's Password: "+ConsoleColors.RESET+e.getEngPassword());
				System.out.println(ConsoleColors.ORANGE+"Department : "+ConsoleColors.RESET+e.getDeptName());
				System.out.println(ConsoleColors.BLACK_BOLD_BRIGHT+"========================================="+ConsoleColors.RESET);
			});
		} catch (EngineerException e) {
			System.out.println(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			System.out.println();
		}
	}

}
