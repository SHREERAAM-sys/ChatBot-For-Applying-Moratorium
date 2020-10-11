import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserRegistrationService } from '../services/user-registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user=new User("","","","","","");
  
  routerException:boolean = true;
  message:any;
  constructor(private service:UserRegistrationService,private router: Router) {
    
   }

  ngOnInit(): void {
  }
    public registerNow()
  {
    console.log("vanthuten sucess");
    let resp=this.service.doRegistration(this.user);
    resp.subscribe((data)=>console.log(data));
    //console.log(this.message);
    alert("Registration sucess");
    this.router.navigate(['login']);
  }

}
