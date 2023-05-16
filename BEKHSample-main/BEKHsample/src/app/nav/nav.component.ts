import { Component, OnInit } from '@angular/core';
import { BEKHService } from '../bekh.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

constructor(private service:BEKHService){}
  ngOnInit(): void {
    
    this.service.getData();
    
    
  }
  
}
