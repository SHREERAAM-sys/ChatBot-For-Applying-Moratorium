export class UserConstructor
{
    firstname:string;
	lastname:string;
	email:string;
	password:string;
	phnumber:string;
	accno:string;
	provider:string;
	providerId:string;
	emailVerified :boolean;
    registered :boolean;
	chatbotconvo:boolean;
    applied :boolean;
    adminVerified:boolean;
    adminApproval:boolean;
    

    constructor(firstname:string,lastname: string,email: string,password: string,phnumber: string,accno: string,
        provider:string,providerId:string,emailVerified :boolean,registered :boolean,chatbotconvo:boolean,applied :boolean,adminVerified:boolean,
        adminApproval:boolean)
        {
            this.firstname=firstname;
            this.lastname=lastname;
            this.email=email;
            this.password=password;
            this.phnumber=phnumber;
            this.accno=accno;

            this.provider=provider;
	this.providerId=providerId;
	this.emailVerified =emailVerified;
    this.registered =registered;
	this.chatbotconvo=chatbotconvo;
    this.applied =applied;
    this.adminVerified=adminVerified;
    this.adminApproval=adminApproval;
        } 
        
}