import { Component, OnInit } from '@angular/core';
import { HomeserviceService } from '../services/homeservice.service';
import { User } from '../model/user';
import { Router } from '@angular/router';
import { UserDetails } from '../admin/model/userDetails';
import { BotApplicationComponent } from '../bot-application/bot-application.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private service:HomeserviceService,private router:Router) { 

    this.fun();
  }

  user: any=[];
  routerException:boolean = false;
  ngOnInit(): void {
    
   
  }
  message:UserDetails;
  public fun()
  {
    console.log('in home========');

    this.service.getUserData().subscribe(data=>
    {
      this.message=data;
      console.log('got sthe data=====\n');
      //console.log(this.message);
    
      // this.user.push(this.message);
      // console.log(this.user);
      if(this.message.registered==false && this.message.provider=="google")
      {
        this.router.navigate(['oauthRegistration']);
      }
      else{
        this.router.navigate(['home']);
      }
      //console.log(this.message);
    });
  }

  
  logout()
  {
    localStorage.removeItem('token');
    this.router.navigate(['login']);

  }

  }



