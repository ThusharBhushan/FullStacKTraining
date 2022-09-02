import { Component, OnInit } from '@angular/core';
import { observable } from 'rxjs';
import { UserService } from '../user.service';

@Component({
  selector: 'userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

  users: any[] = [];
  constructor(public userservice:UserService) { }
          
  ngOnInit(): void {
    console.log('clicked');
    const observable = this.userservice.getAllUser();
    observable.subscribe((usersFromServer :any)=>{
             this.users=usersFromServer
    })

  }
  deleteUser(id:number){
    const observable = this.userservice.deleteUser(id);
    observable.subscribe((usersFromServer :any)=>{
      this.users=usersFromServer
      this.userservice.getAllUser();
})

  }
  

}
