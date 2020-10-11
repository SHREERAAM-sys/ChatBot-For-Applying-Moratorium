import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OauthRegistrationServiceService } from '../services/oauth-registration-service.service';
import { User } from '../model/user';

@Component({
  selector: 'app-oauth-registration',
  templateUrl: './oauth-registration.component.html',
  styleUrls: ['./oauth-registration.component.css']
})
export class OauthRegistrationComponent implements OnInit {

  constructor(private service:OauthRegistrationServiceService, private router: Router) { 
    this.fun();
  }

  user=new User("","","","","","");
  
  routerException:boolean = true;
  message:any;
  ngOnInit(): void {
  }

  public fun()
  {
    console.log('in home========');

    this.service.getUserData().subscribe((data:any)=>
    {
      this.user.email=data.email;
      this.message=data;
      console.log('got the data=====\n');
      console.log(this.user);
      //console.log(this.message);
      //console.log(this.message);
    });
    

  }

  public registerNow()
  {
    console.log("vanthuten sucess");
    let resp=this.service.doRegistration(this.user);
    resp.subscribe((data)=>console.log(data));
    //console.log(this.message);
    alert("Registration sucess");
    //console.log(this.user);
    console.log("Navigating to home from OauthREfistration ts");
    this.router.navigate(['home']);
  }

}
