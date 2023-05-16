import { TestBed } from '@angular/core/testing';

import { BEKHService } from './bekh.service';

describe('BEKHService', () => {
  let service: BEKHService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BEKHService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
