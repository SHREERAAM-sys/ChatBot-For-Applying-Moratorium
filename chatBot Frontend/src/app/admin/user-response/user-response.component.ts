import { Component, OnInit } from '@angular/core';
import { UserResponseService } from '../service/user-response.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-response',
  templateUrl: './user-response.component.html',
  styleUrls: ['./user-response.component.css']
})
export class UserResponseComponent implements OnInit {

  constructor(private service:UserResponseService,private router:Router) {
    console.log("Constructor STARTED");
    this.getAllUserResponse();

   }

  ngOnInit(): void {
  }

response:Response[];
getAllUserResponse()
{
  this.service.userResponse().subscribe(result =>
    { 
      this.response =result;
      console.log(this.response);
    }
    )
}

approve(value: string)
{
  this.service.getAcc(value).subscribe((res:any)=>{console.log(res)});
}
decline(value:string)
{
  this.service.getDec(value).subscribe((res:any)=>{console.log(res)});
}
logout()
{
  this.router.navigate(['admin/login']);
}
   


}
