import { Component, OnInit } from '@angular/core';
import { AdminHomeServiceService } from '../service/admin-home-service.service';
import { UserDetails } from '../model/userDetails';
import { Router } from '@angular/router';
//import { Kommunicate } from '@ionic-native/kommunicate/ngx';


@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  constructor(private service:AdminHomeServiceService,private router:Router) { 
    this.getAllUserDetails();
    
  }
  
  ngOnInit(): void {

  }
public allUser: UserDetails[];

getAllUserDetails()
{
  this.service.getAllUser().subscribe(result =>
    { 
      this.allUser =result;
      console.log(this.allUser);
    }
    )
}

toUserResponse()
{
  this.router.navigate(['']);
  //(['admin/user/response']);
}
logout()
{
  this.router.navigate(['admin/login']);
}
   

}
