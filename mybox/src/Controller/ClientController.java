package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.ClientUI;
import Communication.Client;
import Entity.User;

public class ClientController {
	ClientUI login;
	Client clien;
	User user;


	public ClientController(Client client)
	{
		login =new ClientUI();
		this.clien=client;
		login.addLoginActionListener(new LoginListener());
	}

	class LoginListener implements ActionListener
	{
		PrivateSpaceController privateSpace;
		int status;
		boolean isSysAdmin;
		String username;

		public LoginListener()
		{
			privateSpace= new PrivateSpaceController(clien,
					ClientController.this);
		}
		public void actionPerformed(ActionEvent e)
		{
			if(login.getUnametxt().isEmpty() || login.getPasstxt().isEmpty()|| login.getIPtxt().isEmpty())
			{
				SystemMessageController.displayErrorMessage("Please fill all the fields");
			}
			else
			{
				user= new User();
				user.getUserFromDB(clien,login.getUnametxt());

				if(clien.getCurrentUser().getUserName()==null)
					SystemMessageController.displayErrorMessage("This user is not exists in DataBAse");
				else
				{
					status=clien.getCurrentUser().getStatus();
					isSysAdmin=clien.getCurrentUser().isSysAdmin();
					username=clien.getCurrentUser().getUserName();
					clien.setCurrentUsername(username);

					if(login.getPasstxt().equals(clien.getCurrentUser().getPassword()))
					{
						if(status==1)
						{
							SystemMessageController.displayErrorMessage("The user is already logged in");
						}
						else if(status==0)
						{
							user.setStatusDB(clien,1);
							login.setVisible(false);
							if(isSysAdmin=true)
							{	/*open SysAdmin window*/
								//	privatespace.openPrivateSpaceUserUI();
							}
							else if(isSysAdmin==false)
							{//	privatespace.openPrivateSpaceSysAdminUI();}



							}
						}
						else
						{
							SystemMessageController.displayErrorMessage("The password is incorrect");


						}

					}
				}
				login.clearFields();
			}
		}
	}
}

